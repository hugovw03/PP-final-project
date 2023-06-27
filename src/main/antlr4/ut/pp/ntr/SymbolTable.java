package main.antlr4.ut.pp.ntr;

/** Store and tests for nested scopes of variable declarations.
 * A newly constructed {@link SymbolTable} should consist of a single
 * (outer) scope.
 */
public interface SymbolTable<R> {
    /** Adds (pushes) a next scope level. */
    public void openScope();
    /** Removes (pops) the top scope level. */
    public void closeScope();
    /** Declares a given ID in the top scope. */
    public boolean put(String id, R rec);
    /** Looks up the declaration of a given ID. */
    public R get(String id);
}
