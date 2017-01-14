#!/usr/bin/env perl

use strict;
use warnings;
use List::Util qw(sum);

while (<STDIN>) {
  my @nums = sort (split /\s/);
  my $min = sum @nums[0 .. 3];
  my $max = sum @nums[-1,-2,-3,-4];
  print "$min $max\n"
}
