# Test Metrics

This project makes use of static analysis to extract metrics from test code.
This tool extends [mauricioaniche/ck] tool. Currently, the tool generates a 
CSV file with all
CK metrics plus a boolean on whether a file is a test file (`istest`), number
of assert methods (`asserts`), and number of test methods (`testmethods`).

[mauricioaniche/ck]: http://www.github.com/mauricioaniche/ck

## Usage

```
java -jar tool.jar <path to source code dir> <path to output csv file>
```

## License

This software is licensed under Apache 2.0 License.