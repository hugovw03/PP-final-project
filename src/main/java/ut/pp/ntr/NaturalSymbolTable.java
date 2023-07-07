package ut.pp.ntr;

import java.util.Stack;

public class NaturalSymbolTable {

    private final Stack<Scope> scopes;
    private  int counter = 0;


    public NaturalSymbolTable() {
        this.scopes = new Stack<>();
        this.scopes.push(new Scope(0));
    }


    public void openScope() {
        counter += this.scopes.peek().getSize();
        this.scopes.push(new Scope(counter));
    }


    //Removes the deepest scope level.
    public void closeScope() {
        if (this.scopes.size() == 1) {
            throw new IllegalStateException("Can't close outer scope");
        }
        int size = this.scopes.peek().getSize();
        this.scopes.pop();
        this.scopes.peek().setSize(size);
    }


    //Tries to declare a given identifier in the deepest scope level.
    public boolean put(String id, Type record) {
        return this.scopes.peek().put(id, record);
    }


    //Looks up a given identifier and returns the associated type.
    public Type type(String id) {
        Type result = null;
        for (int i = this.scopes.size() - 1; result == null && i >= 0; i--) {
            result = this.scopes.get(i).type(id);
        }
        return result;
    }

//    Returns the offset of an identifier within its own scope. The
//    offset is the sum of the sizes of all types declared before the
//    identifier.
    public int offset(String id) {
        Integer result = null;
        for (int i = this.scopes.size() - 1; result == null && i >= 0; i--) {
            result = this.scopes.get(i).offset(id);
        }
        return result == null ? -1 : result;
    }

//    Tests if a given identifier is in the scope of any declaration.
    public boolean containInScope(String id) {
        for (Scope scope : this.scopes) {
            if (scope.contains(id)) {
                return true;
            }
        }
        return false;
    }
}