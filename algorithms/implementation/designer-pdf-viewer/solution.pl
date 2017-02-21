use strict;
use warnings;

my $line;
chomp($line = <STDIN>);
my @heights = split ' ', $line;

chomp($line = <STDIN>);
my $max_height = 0;
for my $letter (split '',$line) {
    $max_height = $heights[ord ($letter) - ord 'a'] if $heights[ord ($letter) - ord 'a'] > $max_height;
}

print $max_height * length $line;
