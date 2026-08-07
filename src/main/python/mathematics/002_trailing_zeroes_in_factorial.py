# Problem 002: For an integer n, find the number of trailing zeroes in n!.


def trailing_zeroes(n: int) -> int:
    zero_count = 0
    divisor = 5

    while divisor <= n:
        number_of_fives = n // divisor
        zero_count = zero_count + number_of_fives
        divisor = divisor * 5
    return zero_count


if __name__ == "__main__":
    n = 25
    print(trailing_zeroes(n))