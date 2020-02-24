package com.example.designpattern.create.build;

/**
 * Created by zyy on 20/2/17.
 */
public class ConstructorArg {

    private boolean isRef;
    private Class type;
    private Object arg;

    public boolean isRef() {
        return isRef;
    }

    public Class getType() {
        return type;
    }

    public Object getArg() {
        return arg;
    }

    private ConstructorArg(Builder builder) {
        this.isRef = builder.isRef;
        this.type = builder.type;
        this.arg = builder.arg;
    }

    public static class Builder {
        private boolean isRef;
        private Class type;
        private Object arg;

        public ConstructorArg build() {
            if(isRef && type != null) {
                throw new IllegalArgumentException("...");
            }

            if (!isRef && type == null) {
                throw new IllegalArgumentException("...");
            }

            if (this.isRef && (arg != null && arg.getClass() != String.class)) {
                throw new IllegalArgumentException("...");
            }

            if (!this.isRef && arg == null) {
                throw new IllegalArgumentException("...");
            }

            return new ConstructorArg(this);
        }

        public Builder setRef(boolean ref) {
            if(ref && this.type != null) {
                throw new IllegalArgumentException("...");
            }
            this.isRef = ref;
            return this;
        }

        public Builder setType(Class type) {
            if (this.isRef || type == null) {
                throw new IllegalArgumentException("...");
            }
            this.type = type;
            return this;
        }

        public Builder setArg(Object arg) {
            if (this.isRef && (arg != null && arg.getClass() != String.class)) {
                throw new IllegalArgumentException("...");
            }

            if (!this.isRef && arg == null) {
                throw new IllegalArgumentException("...");
            }
            this.arg = arg;
            return this;
        }
    }

    public static void main(String[] args) {
        ConstructorArg arg = new ConstructorArg.Builder()
                .setRef(true)
                .setType(String.class)
                .setArg("kkk")
                .build();
        System.out.println(arg.toString());
    }

}
