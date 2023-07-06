import unittest
import minion
import minionMut

class Testminion(unittest.TestCase):
    def test_triple(self):
        cases = [
            (2, 6),
            (4, 12),
            (10, 30),
            (5, 20)
        ]
        for inp, exp in cases:
            with self.subTest(inp=inp, exp=exp):
                obtained = minion.triple(inp)
                self.assertEqual(obtained, exp, "Triple(%s) should be %s, not %s" % (inp, obtained, exp))

    def test_minNum(self):
        cases = [
            ([2, 4, 5, 1, 6, 7, 9], 1),
            ([32, 12, 54, 49, 53, 13, 42], 12),
            ([8, 23, 12, 49, 21, 43, 23, 85, 54, 12], 8)
            ]
        for inp, exp in cases:
            with self.subTest(inp=inp, exp=exp):
                obtained = minion.minNum(inp)
                self.assertEqual(obtained, exp, "minNum(%s) should be %s, not %s" % (inp, obtained, exp))

    def test_sumArray(self):
        cases = [
            ([1, 2, 3, 4, 5, 6, 7, 8, 9], 45),
            ([5, 5, 5, 5, 5, 5], 30),
            ([7, 18, 3, 5, 12, 2, 9, 1], 57)
            ]
        for inp, exp in cases:
            with self.subTest(inp=inp, exp=exp):
                obtained = minion.sumArray(inp)
                self.assertEqual(obtained, exp, "sumArray(%s) should be %s, not %s" % (inp, obtained, exp))

    def test_bubbleSort(self):
        cases = [
            ([5, 3, 5, 1, 9, 2, 4, 7, 8, 6, 12], [1, 2, 3, 4, 5, 5, 6, 7, 8, 9, 12]),
            ([1, 2, 3, 4, 5], [1, 2, 3, 4, 5]),
            ([9, 8, 7, 6, 5, 4, 3, 2, 1], [1, 2, 3, 4, 5, 6, 7, 8, 9])
        ]

        for inp, exp in cases:
            with self.subTest(inp=inp, exp=exp):
                obtained = minion.bubbleSort(inp)
                self.assertEqual(obtained, exp, "bubblesort(%s) should be %s, not %s" % (inp, obtained, exp))

    def test_houseAlarm(self):
        cases = [
            (0, 0, False),
            (1, 0, True),
            (2, 0, True)
        ]
        for inp1, inp2, exp in cases:
            with self.subTest(inp1=inp1, inp2=inp2, exp=exp):
                obtained = minion.houseAlarm(inp1, inp2)
                self.assertEqual(obtained, exp, "houseAlarm(%s, %s) should be %s, not %s" % (inp1, inp2, obtained, exp))

    def test_sumArrayMut(self):
        cases = [
            ([1, 2, 3, 4, 5, 6, 7, 8, 9], 45),
            ([5, 5, 5, 5, 5, 5], 30),
            ([7, 18, 3, 5, 12, 2, 9, 1], 57)
            ]
        for inp, exp in cases:
            with self.subTest(inp=inp, exp=exp):
                obtained = minionMut.sumArrayMut1(inp)
                self.assertEqual(obtained, exp, "sumArray(%s) should be %s, not %s" % (inp, obtained, exp))