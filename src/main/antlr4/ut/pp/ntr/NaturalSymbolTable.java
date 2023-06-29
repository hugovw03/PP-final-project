package main.antlr4.ut.pp.ntr;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NaturalSymbolTable implements SymbolTable {

    private final Stack<Map<String, Type>> scopes;
    //for later use Information lost when scope is closed (i.e., stack is popped)



    public NaturalSymbolTable() {
        scopes = new Stack<>();
        openScope(); // Start with the outermost scope
    }

    @Override
    public void openScope() {
        scopes.push(new HashMap<>());
//        int x = scopeStack.size();
//        System.out.println("scope "+ x +" opened");
    }

    @Override
    public void closeScope() {
        if (scopes.size() <= 1) {
            throw new RuntimeException("Cannot close the outermost scope.");
        }
        scopes.pop();
    }

    @Override
    public boolean put(String id, Type type) {
        Map<String, Type> currentScope = scopes.peek();
        if (currentScope.containsKey(id)) {
            return false; // Variable already declared in the current scope
        }
        currentScope.put(id, type);
        System.out.println("Current scope contains:" + scopes);
        return true;
    }

    @Override
    public Type get(String id) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Map<String, Type> scope = scopes.get(i);
            if (scope.containsKey(id)) {
                return scope.get(id);
            }
        }
        return null; // Variable not found in any scope
    }
}