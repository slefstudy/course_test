package ru.parsentev.task_007;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * TODO: comment
 *
 * @author parsentev
 * @since 28.07.2016
 */
public class Expression {
    private static final Logger log = getLogger(Expression.class);

    private final String expr;

    public Expression(final String expr) {
        this.expr = expr;
    }

    public double calc() {
        final String[] values = this.expr.split("(\\+|-|/|\\*)");
        if (values.length == 2) {
            final int size =  values[0].length();
            return this.calc(
                    Double.valueOf(values[0]),
                    Double.valueOf(values[1]),
                    this.expr.substring(size + 1, size + 2)
            );
        } else {
            throw new IllegalStateException();
        }
    }

    public double calc(double first, double second, String op) {
        final double result;
        if ("+".equals(op)) {
            result = first + second;
        } else if ("-".equals(op)) {
            result = first - second;
        } else if ("/".equals(op)) {
            result = first / second;
        } else {
            result = first * second;
        }
        return result;
    }
}
