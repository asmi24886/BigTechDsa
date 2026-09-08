# Time Complexity — Explained Like You're Learning It Fresh

Forget formulas for a second. Time complexity just answers one question:

> **"If I double the input size, how much MORE work does my code do?"**

That's it. Everything below is just different answers to that question.

---

## The core idea: count the loops, watch the recursion

There are really only **two things** that create complexity in code:
1. **Loops** (`for`, `while`)
2. **Recursion** (a function calling itself)

Let's go through both like a story.

---

## Part 1: Loops

### One loop = O(N)
```python
for i in range(n):
    print(i)
```
Think of it like **reading every page of a book once**. 100 pages → 100 units of work. 1000 pages → 1000 units. Work grows *exactly as fast* as input. That's **O(N)** — "linear."

### Two loops, one after another = still O(N)
```python
for i in range(n):
    print(i)
for j in range(n):
    print(j)
```
Like reading the book once, then reading it again. Two separate readings. It's O(N) + O(N) = O(2N). But in Big-O we **drop constants** — we only care about the *shape* of growth, not exact counts. So this is still **O(N)**.

### One loop inside another = O(N²)
```python
for i in range(n):
    for j in range(n):
        print(i, j)
```
Think of it like: **for every page in the book, you re-read the entire book**. 100 pages → for each of the 100 pages, read 100 pages again = 10,000 units of work. That's **O(N²)** — "quadratic." Nested loops over the same N = multiply.

**Rule of thumb: count how many loops are nested inside each other over the same input. That count = the power.**
- 1 loop → N¹
- 2 nested loops → N²
- 3 nested loops → N³

### A loop that jumps instead of crawls = O(log N)
```python
i = 1
while i < n:
    i = i * 2
```
Instead of `i` going 1, 2, 3, 4, 5... it goes 1, 2, 4, 8, 16, 32... **doubling** each time.

Analogy: **guessing a number between 1 and 1000 by always guessing the middle** ("is it higher or lower?"). Each guess cuts the remaining possibilities in half. You never need more than ~10 guesses even for 1000 numbers. That's **O(log N)** — "logarithmic." It barely grows even when N gets huge. This is why binary search is fast.

---

## Part 2: Recursion (the part most students find scary)

Here's the trick: **draw the recursion as a tree, and ask two questions.**

1. **How many branches does each call split into?** (this is called the *branching factor*)
2. **How many levels deep does the tree go?** (this is the *depth*)

Then: **Total work ≈ branches^depth**

### Example A: One call, shrinks by 1 each time → O(N)
```python
def countdown(n):
    if n == 0:
        return
    countdown(n - 1)
```
This is a straight line, not a tree — 1 branch each time, N levels deep. Like walking down a staircase with N steps, one at a time. **O(N)**.

### Example B: One call, shrinks by HALF each time → O(log N)
```python
def binary_search(arr, low, high):
    if low > high: return
    mid = (low + high) // 2
    # recurse on left OR right half, not both
```
Same "staircase" idea, but each step skips half the remaining stairs. Only ~log N steps needed. **O(log N)**.

### Example C: TWO calls each time, shrinks by 1 → O(2^N) — THIS IS YOUR CASE
```python
def solve(i, n):
    if i == n:
        return
    solve(i + 1, n)   # skip this item
    solve(i + 1, n)   # take this item
```
Now picture a **family tree**: every person has exactly 2 children, and the tree goes N generations deep.

- Generation 0: 1 person
- Generation 1: 2 people
- Generation 2: 4 people
- Generation 3: 8 people
- ...
- Generation N: 2^N people

**That's exactly your "2 choices for N items" situation.** Every item gets a yes/no decision, and you're exploring every possible combination of decisions. Total number of decision-paths = 2 × 2 × 2 × ... (N times) = **2^N**.

> **The general rule: if each item has `k` independent choices, and you try all combinations → O(k^N).**
> - 2 choices (yes/no, include/exclude) → 2^N
> - 3 choices → 3^N
> - This shows up in: subsets, the 0/1 knapsack brute force, generating all binary strings, subset-sum brute force.

### Example D: Splits in half, but does N work at each split → O(N log N)
```python
def merge_sort(arr):
    if len(arr) <= 1: return arr
    mid = len(arr) // 2
    left = merge_sort(arr[:mid])
    right = merge_sort(arr[mid:])
    return merge(left, right)  # this merge step costs O(N)
```
Tree depth = log N (halving each time), but at **every level of the tree**, merging all the pieces back together costs O(N) total. So: log N levels × N work per level = **O(N log N)**.

This is the classic "sorting" complexity — better than N² (nested loops) but worse than N (single pass).

---

## Part 3: The "all possible X" giveaways

Sometimes you don't even need to trace the code — the *problem itself* tells you the complexity:

| Problem says... | Complexity | Why |
|---|---|---|
| "all subsets of N items" | 2^N | each item: in or out |
| "all permutations (orderings) of N items" | N! | 1st item: N choices, 2nd: N-1 choices, 3rd: N-2... |
| "all pairs" | N² | pick 2 out of N |
| "all triplets" | N³ | pick 3 out of N |

---

## Part 4: The one-line mental checklist

When you look at any code, ask:

1. **Any loops?** → Are they nested? Nesting = multiply (N², N³...). Sequential = add, but keep the biggest one.
2. **Does a loop variable double/halve instead of +1/-1?** → log N.
3. **Any recursion?** → Draw the tree in your head:
   - How many calls per level (branches)?
   - How many levels (depth)?
   - Multiply: **branches^depth**
   - But if there's real work (like merging) done at each level too, add that in: **branches^depth × work_per_level**

---

## Part 5: Speed ranking (memorize this order)

From fastest-growing-slowly to slowest-growing-fast (i.e., best to worst):

```
O(1)  →  O(log N)  →  O(N)  →  O(N log N)  →  O(N²)  →  O(N³)  →  O(2^N)  →  O(N!)
```

Think of it as a race where N = 1,000:
- O(log N) ≈ 10 steps
- O(N) ≈ 1,000 steps
- O(N²) ≈ 1,000,000 steps
- O(2^N) ≈ more steps than atoms in the universe (seriously — this is why brute-force subset problems only work for small N, like N ≤ 20-25)
