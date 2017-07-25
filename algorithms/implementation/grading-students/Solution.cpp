int round_grade(int grade) {
    if(grade < 38) return grade;

    const int rounded_grade =
        (grade % 5) >= 3 ?
            5 - (grade % 5) + grade
            : grade;

    return rounded_grade;
}