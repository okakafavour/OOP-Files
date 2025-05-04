package Problem;
import java.util.ArrayList;
import java.util.List;

public class Person {
    private List<Problem> problems;

    public Person() {
        this.problems = new ArrayList<>();
    }


    public Problem createProblem(String name, String type) {
        return new Problem(name, type);
    }


    public void addProblem(Problem problem) {
        problems.add(problem);
    }


    public void solveProblem(String problemName) {
        for (Problem problem : problems) {
            if (problem.getName().equals(problemName)) {
                problem.setSolved(true);
                break;
            }
        }
    }


    public List<String> recountUnsolvedProblems() {
        List<String> unsolved = new ArrayList<>();
        for (Problem problem : problems) {
            if (!problem.isSolved()) {
                unsolved.add(problem.getName());
            }
        }
        return unsolved;
    }


    public List<Problem> getProblems() {
        return problems;
    }


}