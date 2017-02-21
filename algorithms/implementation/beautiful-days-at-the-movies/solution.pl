use strict;
use warnings;

chomp(my $line = <STDIN>);
my ($i,$j,$k) = split ' ', $line;
my $count = 0;
for my $n ($i .. $j) {
    if(abs($n - scalar reverse $n) % $k == 0) {
        $count++;
    }
}

print $count;
