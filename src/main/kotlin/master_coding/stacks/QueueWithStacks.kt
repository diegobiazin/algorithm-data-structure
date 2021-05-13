package master_coding.stacks

import java.util.*

class QueueWithStacks(
    val input: Stack<String>,
    val out: Stack<String>
) {

    fun enqueue(value: String) {
        input.push(value)
    }

    fun dequeue(): String {
        if (out.size == 0) {
            while (this.input.size > 0) {
                this.out.push(this.input.pop());
            }
        }

        return this.out.pop()
    }

    fun peek(): String {
        if (this.out.size == 0) {
            while (this.input.size > 0) {
                this.out.push(this.input.pop());
            }
        }

        return this.out[this.out.size - 1];
    }

    fun empty(): Boolean {
        return this.input.size == 0 && this.out.size == 0
    }
};