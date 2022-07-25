package algo.patterns.dfs;

import java.util.*;

public class GenerateParenthesis_test {

	static String indent = "";

	public static List<String> generateParenthesis (int n) {
		List<String> res = new ArrayList<>();
		if(n <= 0) return res;
		solve(0, new StringBuilder(), n, res);
		return res;
	}

	// Generating all combinations and then validating well formed 
	public static void solve(int idx, StringBuilder sb, int n, List<String> res) {
		if(idx == 2*n) {
			res.add(sb.toString());
			return;
		}

		sb.append("(");
		enter(sb.toString());
		solve(idx+1, sb, n, res);
		sb.deleteCharAt(sb.length()-1);
		leave(sb.toString());

		sb.append(")");
		enter(sb.toString());
		solve(idx+1, sb, n, res);
		sb.deleteCharAt(sb.length()-1);
		leave(sb.toString());
	}

	public static List<String> generateAllParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public static void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

	public static void main(String[] args) {
		List<String> res = generateParenthesis(1);
		for(String s : res) {
			System.out.print(s + " ");
		}
	}

	public static void enter(String a) {
		System.out.println(indent + "Entering foo " + a);
		indent = indent + "|  ";
	}

	public static void leave(String a) {
		indent = indent.substring(3);
		System.out.println(indent + "Leaving foo " + a);
	}
}