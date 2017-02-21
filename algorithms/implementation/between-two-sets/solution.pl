use strict;
use warnings;

my $line;
chomp($line = <STDIN>);
my @els = split ' ', $line;
chomp($line = <STDIN>);
my @arr_a = sort (split ' ', $line);
chomp($line = <STDIN>);
my @arr_b = sort (split ' ', $line);

my $a_hi = $arr_a[$#arr_a];
my $b_lo = $arr_b[0];
my $count = 0;


N: for my $n ($a_hi .. $b_lo) {
    for my $a (@arr_a) {
        next N if $n % $a != 0;
    }
    for my $b (@arr_b) {
        next N if $b % $n != 0;
    }
    $count++;
    $n++;
}

print $count;
