package Reqvest;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;

public class RequestRestriction {


    public static void main(String[] args) throws IOException {


        Scanner scanner = new Scanner(System.in);
        int userLimit = scanner.nextInt();

        int serviceLimit = scanner.nextInt();
        int duration = scanner.nextInt();
        scanner.nextLine();
        final int[] serviceRequestCount = {1};
        Map<Integer, Integer> users = new HashMap<>();
        Map<Integer, List<Integer>> times = new HashMap<>();
        String data;
        while (!"-1".equals(data = scanner.nextLine())) {
            String[] str = data.split(" ");
            int time = Integer.parseInt(str[0]);
            int userId = Integer.parseInt(str[1]);
           // System.err.println(userId);



            if (users.containsKey(userId)) {
                Integer integer = users.get(userId);
                users.replace(userId, integer + 1);
            } else {
                users.put(userId, 1);
            }
           // System.err.println(users.get(userId));
            if (times.containsKey(time)) {
                times.get(time).add(userId);
            } else {
                List<Integer> myArray = new ArrayList<>();
                myArray.add(userId);
                times.put(time, myArray);
            }

            if ((time - duration - 1) > 0) {
                for (int j = 1; j <= (time - duration); j++) {
                    List<Integer> userIds = times.get(j);
                    if (userIds != null) {
                        userIds.forEach(userId1 -> {
                            Integer userRequestCount = users.get(userId1);
                            if (userRequestCount > 0) {
                                users.replace(userId1, userRequestCount - 1);
                                serviceRequestCount[0]--;
                            }
                        });
                    }
                }
            }

            if (users.get(userId) > userLimit) {
                System.out.println("429");
            } else {
                if (serviceRequestCount[0] > serviceLimit) {
                    System.out.println("503");
                } else {
                    System.out.println("200");
                    serviceRequestCount[0]++;
                }
            }
        }

    }

}
