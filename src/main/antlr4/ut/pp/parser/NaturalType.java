package main.antlr4.ut.pp.parser;


/** Pascal data type. */
abstract public class NaturalType {
    /**
     * The singleton instance of the {@link Bool} type.
     */
    public static final NaturalType BOOL = new Bool();
    /**
     * The singleton instance of the {@link Int} type.
     */
    public static final NaturalType INT = new Int();
    private final TypeKind kind;

    /**
     * Constructor for subclasses.
     */
    protected NaturalType(TypeKind kind) {
        this.kind = kind;
    }

    /**
     * Returns the kind of this type.
     */
    public TypeKind getKind() {
        return this.kind;
    }

    /**
     * returns the size (in bytes) of a value of this type.
     */
    abstract public int size();

    /**
     * Representation of the Pascal Boolean type.
     */
    static public class Bool extends NaturalType {
        private Bool() {
            super(TypeKind.BOOL);
        }

        @Override
        public int size() {
//            return Machine.INT_SIZE;
        }

        @Override
        public String toString() {
            return "Boolean";
        }
    }

    /**
     * Representation of the Pascal Integer type.
     */
    static public class Int extends NaturalType {
        private Int() {
            super(TypeKind.INT);
        }

        @Override
        public int size() {
            return 1;
        }

        @Override
        public String toString() {
            return "Integer";
        }
    }
}

    /** Representation of Pascal Array types. */



