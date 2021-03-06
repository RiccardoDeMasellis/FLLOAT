/*
 * FFLOAT  Copyright (C) 2015  Riccardo De Masellis.
 *
 * This program comes with ABSOLUTELY NO WARRANTY.
 * This is free software, and you are welcome to redistribute it
 * under certain conditions; see http://www.gnu.org/licenses/gpl-3.0.html for details.
 */

package automaton;

/**
 * Created by Riccardo De Masellis on 09/07/15.
 */
public class
        EmptyTrace implements TransitionLabel {

    public boolean equals(Object other) {
        if (other == null)
            return false;
        else
            return this.getClass().equals(other.getClass());
    }

    public int hashCode() {
        return this.getClass().hashCode();
    }

    public String toString() {
        return "EmpTr";
    }
}
