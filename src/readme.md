Overview
--------

The Calculator class is a simple implementation of a string calculator that takes a
string of numbers separated by commas or new lines and returns their sum.

Features
--------

* Handles custom delimiters
* Handles negative numbers
* Handles edge cases such as empty strings, strings with no numbers, and strings with trailing commas

Code Logic
----------

`add` Method
------------

The `add` method is the core of the Calculator class. It takes a string of numbers
separated by commas or new lines and returns their sum.

### Step 1: Check for Empty String

If the input string is empty, return 0.

### Step 2: Check for Custom Delimiter

If the input string starts with "//", it indicates a custom delimiter.
Split the input string into two parts: the custom delimiter and the numbers.
If there are no numbers, return 0.

### Step 3: Split Numbers

If there is a custom delimiter, split the numbers using the custom delimiter.
Otherwise, split the numbers using commas and new lines.

### Step 4: Calculate Sum

Initialize a sum variable to 0.
Iterate through the numbers and add them to the sum.
If a number is negative, collect it in a StringBuilder.

### Step 5: Handle Negative Numbers

If there are any negative numbers, throw an `IllegalArgumentException` with a
message containing all negative numbers.

### Step 6: Return Sum

Return the calculated sum.

Example Use Cases
----------------

* `calculator.add("1,2,3")` returns 6
* `calculator.add("//;\n1;2;3")` returns 6
* `calculator.add("1,2,-3")` throws an `IllegalArgumentException`

Test Cases
----------

The Calculator class has a comprehensive set of test cases to ensure its correctness.

* `testAdd`: Verifies that the `add` method returns 0 when given an empty string.
* `testAddSingle`: Verifies that the `add` method returns the correct result when
  given a string with a single number.
* `testAddMultiple`: Verifies that the `add` method returns the correct sum when
  given a string with multiple numbers.
* `testAddWithCustomDelimiter`: Verifies that the `add` method supports custom
  delimiters.
* `testAddWithNegativeNumbers`: Verifies that the `add` method throws an exception
  when given a string containing negative numbers.

Commit Message Guidelines
-------------------------

* Keep the first line concise (<50 characters)
* Use bullet points for multiple changes

API Documentation Guidelines
----------------------------

* Use JavaDoc-style comments for method documentation
* Include a brief summary of the method's purpose
* List all parameters and their types
* List all return values and their types
* Include any relevant examples or notes