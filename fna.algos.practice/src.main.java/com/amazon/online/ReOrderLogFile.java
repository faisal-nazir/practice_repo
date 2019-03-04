package com.amazon.online;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** Log File
You have been given a task of recording some data 40M a log file. In the log file, every line is a space-delimited list of strings. All lines begin with an alphanumeric identifier. There will be no lines consisting only of an identifier.
After the alphanumeric identifier a line will consist of either:from aonecode.com
- a list of words using only lowercase English lettersfrom aonecode.com
- or list of only integers.
You have to reorder the data such that all of the lines with words are at the top of the log file. The lines with words are ordered lexicographically. ignoring the identifier except in the case of ties In the case of ties (if there are two lines that are identical except for the identifier) the identifier is used to order lexicographically. Alphanumeric should be sorted in ASCII order (numbers come before letters) The identifiers most still be pan of the lines in the output Strings. Lines with integers must be left in the original order they were in the file.from aonecode.com
Write an algorithm to reorder the data in the log file, according to the rules above.from aonecode.com
Input
The input to the function/method consists of two argument - logFileSize, an integer representing the number of log lines. 
logLines, a list of strings representing the log file.

from aonecode.com from aonecode.com
Outputfrom aonecode.com
Return a list of strings representing the reordered log file data.from aonecode.com

Note
Identifier consists of only lower case english character and numbers.from aonecode.com

Example from aonecode.com

Input
logFileSize = 5from aonecode.com
logLines = 
[a1 9 2 3 1] 
[g1 act car] [zo4 4 7] 
[ab1 off key dog]from aonecode.com
[a8 act zoo]

Output
[g1 act car]from aonecode.com
[a8 act zoo]
[ab1 off key dog]from aonecode.com
[zo4 4 7]
[a1 9 2 3 1]
**/
public class ReOrderLogFile {

	public static List<String> reorderLogFiles(List<String> logs) {
        Collections.sort(logs, new LogComparator());
        return logs;
    }
	
	private static class LogComparator implements Comparator<String> {
		public int compare(String s1, String s2) {
			int idx_s1 = s1.indexOf(' ');
			int idx_s2 = s2.indexOf(' ');
			char fc_s1 = s1.charAt(idx_s1+1);
			char fc_s2 = s2.charAt(idx_s2+1);
			
			if(Character.isDigit(fc_s1) && Character.isDigit(fc_s2))
				return 0;
			else if(Character.isDigit(fc_s1)) 
				return 1;
			else if(Character.isDigit(fc_s2))
				return -1;
			else {
				// both values are strings
				int comp = s1.substring(idx_s1+1).compareTo(s2.substring(idx_s2+1));
				if(comp == 0)
					// if strings are same then sort on keys
					return s1.substring(0, idx_s1).compareTo(s2.substring(0, idx_s2));
				return comp; // otherwise sort on values
			}
		}
	}
	
	public static void main(String[] args) {
		List<String> logs = new ArrayList<String>();
		logs.add("a1 9 2 3 1");
		logs.add("g1 act car");
		logs.add("zo4 4 7");
		logs.add("ab1 off key dog");
		logs.add("a8 act zoo");
		
		logs = reorderLogFiles(logs);
		for(String line : logs) {
			System.out.println(line);
		}
	}
}
