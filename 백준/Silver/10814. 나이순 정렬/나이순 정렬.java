import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            solution(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void solution(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            members.add(new Member(Integer.parseInt(input[0]), input[1], i));
        }
        members.sort(Comparator
                         .comparingInt((Member member) -> member.age)
                         .thenComparingInt(member -> member.order));

        StringBuilder sb = new StringBuilder();
        for (Member member : members) {
            sb.append(member.age).append(" ").append(member.name).append("\n");
        }
        System.out.println(sb);
    }

    static class Member {

        int age;
        String name;
        int order;

        public Member(int age, String name, int order) {
            this.age = age;
            this.name = name;
            this.order = order;
        }

    }

}