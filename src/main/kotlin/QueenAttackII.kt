fun main() {
    print(queensAttack(5, 3, 4, 3, arrayOf(arrayOf(5, 5), arrayOf(4, 2), arrayOf(2, 3))))
}

fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {
    var u = n - r_q
    var d = r_q - 1
    var r = n - c_q
    var l = c_q - 1
    var ru = Math.min(u, r)
    var rd = Math.min(r, d)
    var lu = Math.min(l, u)
    var ld = Math.min(l, d)
    for (o in obstacles) {
        when {
            o[1] == c_q -> {
                if (o[0] < r_q)
                    d = Math.min(d, r_q - 1 - o[0])
                else
                    u = Math.min(u, o[0] - r_q - 1)
            }
            o[0] == r_q -> {
                if (o[1] < c_q)
                    l = Math.min(l, c_q - 1 - o[1])
                else r = Math.min(r, o[1] - c_q - 1)
            }
            Math.abs(o[0] - r_q) == Math.abs(o[1] - c_q) -> {
                if (o[1] > c_q)
                    if (o[0] > r_q)
                        ru = Math.min(ru, o[1] - c_q - 1)
                    else
                        rd = Math.min(rd, o[1] - c_q - 1)
                else
                    if (o[0] > r_q)
                        lu = Math.min(lu, c_q - 1 - o[1])
                    else
                        ld = Math.min(ld, c_q - 1 - o[1])
            }
        }
    }

    return u + d + r + l + ru + rd + lu + ld
}