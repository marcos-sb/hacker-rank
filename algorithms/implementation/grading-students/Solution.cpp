#include <bits/stdc++.h>

using namespace std;

int round_grade(int grade) {
    if(grade < 38) return grade;

    const int rounded_grade =
        (grade % 5) >= 3 ?
            (grade % 5) + grade - 1
            : grade;

    return rounded_grade;
}

vector < int > solve(vector < int > grades){
    vector<int> rounded_grades;
    for(int grade : grades)
        rounded_grades.push_back(round_grade(grade));

    return rounded_grades;
}
