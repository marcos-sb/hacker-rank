function processData(input) {
    var lines = input.split('\n');
    var n = lines[0];
    var nums = lines[1].split(' ');

    var arr = [];
    for(var i = 0; i<100; i++)
        arr.push(0);

    for(var i = 0; i<n; i++)
        arr[parseInt(nums[i])]++;

    for(var i = 0; i<100; i++)
        process.stdout.write(arr[i]+" ");
}

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});
