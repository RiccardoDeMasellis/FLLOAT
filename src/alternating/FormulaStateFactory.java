package alternating;

import formula.Formula;
import rationals.Automaton;
import rationals.State;
import rationals.StateFactory;
import symbols.Symbol;

import java.lang.reflect.Array;
import java.util.*;

/**
 * This class is used by Automaton objects to create new states on A user can
 * implement its own version of StateFactory by providing an implementation for
 * createState
 *
 * @author Arnaud.Bailly - bailly@lifl.fr
 * @version Thu Apr 25 2002
 */
public class FormulaStateFactory implements StateFactory, Cloneable {

    protected int id = 0;
    Automaton automaton;

    // //////////////////////////////////////////////////////
    // FIELDS
    // /////////////////////////////////////////////////////

    public FormulaStateFactory(Automaton a) {
        this.automaton = a;
    }

    public FormulaStateFactory() {
        this(null);
    }

    // //////////////////////////////////////////////////////
    // PUBLIC METHODS
    // /////////////////////////////////////////////////////

    /**
     * Creates a new state which is initial and terminal or not, depending on the
     * value of parameters.
     *
     * @param initial  if true, this state will be initial; otherwise this state will be
     *                 non initial.
     * @param terminal if true, this state will be terminal; otherwise this state will be
     *                 non terminal.
     */
    public State create(boolean initial, boolean terminal) {
        return new FormulaState(id++, initial, terminal);
    }

    /*
     * (non-Javadoc)
     *
     * @see rationals.StateFactory#stateSet()
     */
    public Set stateSet() {
        return new FormulaStateSet(this);
    }

    /*
     * (non-Javadoc)
     *
     * @see rationals.StateFactory#stateSet(java.util.Set)
     */
    public Set stateSet(Set s) {
        return new FormulaStateSet((FormulaStateSet) s, this);
    }

    public Object clone() {
        FormulaStateFactory cl;
        try {
            cl = (FormulaStateFactory) super.clone();
        } catch (CloneNotSupportedException e) {
            cl = null;
        }
        cl.id = 0;
        return cl;
    }

    /*
     * (non-Javadoc)
     *
     * @see rationals.StateFactory#setAutomaton(rationals.Automaton)
     */
    public void setAutomaton(Automaton automaton) {
        this.automaton = automaton;
    }

    // Not used, beacuse Automaton.add calls create with two parameters only.
    @Override
    public State create(boolean initial, boolean terminal, Object formulaSet) {
        FormulaState formulaState = new FormulaState(id++, initial, terminal);
        formulaState.formulaSet = (HashSet<Formula>) formulaSet;
        return formulaState;
    }

    public class FormulaState<S extends Symbol<?>> implements State {

        public final int i;

        boolean initial;

        boolean terminal;

        Automaton a;

        private HashSet<Formula<S>> formulaSet;

        FormulaState(int i, boolean initial, boolean terminal) {
            this.i = i;
            this.a = automaton;
            this.initial = initial;
            this.terminal = terminal;
            this.formulaSet = new HashSet<Formula<S>>();
        }

        FormulaState(int i, boolean initial, boolean terminal, HashSet<Formula<S>> formula) {
            this.i = i;
            this.a = automaton;
            this.initial = initial;
            this.terminal = terminal;
            this.formulaSet = formula;
        }

        public HashSet<Formula<S>> getFormulaSet() {
            return formulaSet;
        }

        public void setFormulaSet(HashSet<Formula<S>> formula) {
            this.formulaSet = formula;
        }

        public boolean addFormula(Formula<S> formula) {
            return formulaSet.add(formula);
        }


        /*
         * (non-Javadoc)
         *
         * @see salvo.jesus.graph.Vertex#getObject()
         */
        public Object getObject() {
            return new Integer(i);
        }

        /*
         * (non-Javadoc)
         *
         * @see salvo.jesus.graph.Vertex#setObject(java.lang.Object)
         */
        public void setObject(Object object) {
      /* NOOP */
        }

        /*
         * (non-Javadoc)
         *
         * @see rationals.State#setInitial(boolean)
         */
        public State setInitial(boolean initial) {
            this.initial = initial;
            if (initial)
                a.initials().add(this);
            else
                a.initials().remove(this);
            return this;
        }

        /*
         * (non-Javadoc)
         *
         * @see rationals.State#setTerminal(boolean)
         */
        public State setTerminal(boolean terminal) {
            this.terminal = terminal;
            if (terminal)
                a.terminals().add(this);
            else
                a.terminals().remove(this);
            return this;
        }

        /*
         * (non-Javadoc)
         *
         * @see rationals.State#isInitial()
         */
        public boolean isInitial() {
            return this.initial;
        }

        /*
         * (non-Javadoc)
         *
         * @see rationals.State#isTerminal()
         */
        public boolean isTerminal() {
            return this.terminal;
        }

        public String toString() {
            return formulaSet == null ? Integer.toString(i) : formulaSet.toString();
        }

        public boolean equals(Object o) {
            try {
                FormulaState<S> ds = (FormulaState<S>) o;
                return (ds.i == i) && (a == ds.a);
            } catch (ClassCastException e) {
                return false;
            }
        }

        public int hashCode() {
            return i;
        }
    }

    class FormulaStateSet implements Set {

        int modcount = 0;
        int mods = 0;
        int bit = -1;
        BitSet bits = new BitSet();
        Iterator it = new Iterator() {

            public void remove() {
                if (bit > 0)
                    bits.clear(bit);
            }

            public boolean hasNext() {
                return bits.nextSetBit(bit) > -1;
            }

            public Object next() {
                bit = bits.nextSetBit(bit);
                if (bit == -1)
                    throw new NoSuchElementException();
                FormulaState ds = new FormulaState(bit, false, false);
                ds.initial = automaton.initials().contains(ds);
                ds.terminal = automaton.terminals().contains(ds);
                mods++;
                modcount++;
                if (mods != modcount)
                    throw new ConcurrentModificationException();
        /* advance iterator */
                bit++;
                return ds;
            }
        };
        private FormulaStateFactory df;

        /**
         * @param set
         */
        public FormulaStateSet(FormulaStateSet set, FormulaStateFactory df) {
            this.bits = (BitSet) set.bits.clone();
            this.df = df;
        }

        /**
         *
         */
        public FormulaStateSet(FormulaStateFactory df) {
            this.df = df;
        }

        public boolean equals(Object obj) {
            FormulaStateSet dss = (FormulaStateSet) obj;
            return (dss == null) ? false : (dss.bits.equals(bits) && dss.df == df);
        }

        public int hashCode() {
            return bits.hashCode();
        }

        public String toString() {
            StringBuffer sb = new StringBuffer();
            sb.append('[');
            String b = bits.toString();
            sb.append(b.substring(1, b.length() - 1));
            sb.append(']');
            return sb.toString();
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#size()
         */
        public int size() {
            return bits.cardinality();
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#clear()
         */
        public void clear() {
            modcount++;
            bits.clear();
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#isEmpty()
         */
        public boolean isEmpty() {
            return bits.isEmpty();
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#toArray()
         */
        public Object[] toArray() {
            Object[] ret = new Object[size()];
            Iterator it = iterator();
            int i = 0;
            while (it.hasNext()) {
                ret[i++] = it.next();
            }
            return ret;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#add(java.lang.Object)
         */
        public boolean add(Object o) {
            FormulaState ds = (FormulaState) o;
            if (bits.get(ds.i))
                return false;
            bits.set(ds.i);
            modcount++;
            return true;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#contains(java.lang.Object)
         */
        public boolean contains(Object o) {
            FormulaState ds = (FormulaState) o;
            return bits.get(ds.i);
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#remove(java.lang.Object)
         */
        public boolean remove(Object o) {
            FormulaState ds = (FormulaState) o;
            if (!bits.get(ds.i))
                return false;
            bits.clear(ds.i);
            modcount++;
            return true;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#addAll(java.util.Collection)
         */
        public boolean addAll(Collection c) {
            FormulaStateSet dss = (FormulaStateSet) c;
            bits.or(dss.bits);
            modcount++;
            return true;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#containsAll(java.util.Collection)
         */
        public boolean containsAll(Collection c) {
            FormulaStateSet dss = (FormulaStateSet) c;
            BitSet bs = new BitSet();
            bs.or(bits);
            bs.and(dss.bits);
            modcount++;
            return bs.equals(dss.bits);
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#removeAll(java.util.Collection)
         */
        public boolean removeAll(Collection c) {
            FormulaStateSet dss = (FormulaStateSet) c;
            bits.andNot(dss.bits);
            modcount++;
            return true;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#retainAll(java.util.Collection)
         */
        public boolean retainAll(Collection c) {
            FormulaStateSet dss = (FormulaStateSet) c;
            bits.and(dss.bits);
            modcount++;
            return true;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#iterator()
         */
        public Iterator iterator() {
      /* reset iterator */
            bit = modcount = mods = 0;
            return it;
        }

        /*
         * (non-Javadoc)
         *
         * @see java.util.Set#toArray(java.lang.Object[])
         */
        public Object[] toArray(Object[] a) {
            Object[] ret;
            if (a.length == size())
                ret = a;
            else { /* create array dynamically */
                ret = (Object[]) Array.newInstance(a.getClass().getComponentType(),
                        size());
            }
            Iterator it = iterator();
            int i = 0;
            while (it.hasNext()) {
                FormulaState ds = (FormulaState) it.next();
                ret[ds.i] = ds;
            }
            return ret;
        }

    }

}
