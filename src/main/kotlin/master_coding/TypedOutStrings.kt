package master_coding

fun main() {
    val string1 = "ab#z"
    val string2 = "az#z"
    print(backspaceCompare(string1, string2))
    print(backspaceCompareOptimal(string1, string2))
}

fun backspaceCompare(s: String, t: String): Boolean {
    val finalS = buildString(s);
    val finalT = buildString(t);

    if (finalS.size != finalT.size) {
        return false
    } else {
        for (p in finalS.indices) {
            if (finalS[p] != finalT[p]) {
                return false
            }
        }
    }

    return true
}

fun buildString(string: String): MutableList<Char> {
    val builtString = mutableListOf<Char>();
    for (p in string.indices) {
        if (string[p] != '#') {
            builtString.add(string[p]);
        } else {
            builtString.removeAt(p - 1);
        }
    }

    return builtString;
}

fun backspaceCompareOptimal(S: String, T: String): Boolean {
    var p1 = S.length - 1
    var p2 = T.length - 1

    while (p1 >= 0 || p2 >= 0) {
        if (S[p1] == '#' || T[p2] == '#') {
            if (S[p1] == '#') {
                var backCount = 2;

                while (backCount > 0) {
                    p1--
                    backCount--

                    if (S[p1] == '#') {
                        backCount += 2
                    }
                }
            }

            if (T[p2] == '#') {
                var backCount = 2

                while (backCount > 0) {
                    p2--
                    backCount--

                    if (T[p2] == '#') {
                        backCount += 2
                    }
                }
            }
        } else {
            if (S[p1] != T[p2]) {
                return false
            } else {
                p1--
                p2--
            }
        }
    }

    return true
}
