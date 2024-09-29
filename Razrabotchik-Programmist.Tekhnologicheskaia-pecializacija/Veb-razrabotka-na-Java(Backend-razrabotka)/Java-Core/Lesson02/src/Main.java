public class Main {
    public static void main(String[] args) {
        SeminarHomework seminarHomework = new SeminarHomework();
        LectureHomework lectureHomework = new LectureHomework();

        int[] nums = {2, 0, 2, 0, 0, 4};

        System.out.println(seminarHomework.countEvens(nums));
        System.out.println(seminarHomework.maxMinDifference(nums));
        System.out.println(seminarHomework.hasTwoConsecutiveZeros(nums));
    }
}