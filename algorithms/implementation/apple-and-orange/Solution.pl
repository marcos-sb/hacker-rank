#!/usr/bin/env perl

use strict;
use warnings;

my ($s,$t) = split / /, <STDIN>;
my ($a,$b) = split / /, <STDIN>;
my ($m,$n) = split / /, <STDIN>;
my @apples_over_house = grep { $_ + $a >= $s && $_ + $a <= $t } (split / /, <STDIN>);
my @oranges_over_house = grep { $_ + $b >= $s && $_ + $b <= $t } (split / /, <STDIN>);

my $apple_count = 0;
foreach my $d_apple (@apples_over_house) {
  $apple_count++;
}

my $orange_count = 0;
foreach my $d_orange (@oranges_over_house) {
  $orange_count++;
}

print "$apple_count\n$orange_count";
