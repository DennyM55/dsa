# Problem 001: Find the total number of digits required to write all numbers from 1 to n.

def total_digits(n: int) -> int:
    if not isinstance(n, int):
        raise TypeError("n must be an integer")

    if n <= 0:
        return 0

    total = 0
    start = 1
    digits = 1

    while start <= n:
        end = min(n, start * 10 - 1)
        total += (end - start + 1) * digits

        start *= 10
        digits += 1

    return total


if __name__ == "__main__":
    n = 13
    print(total_digits(n))