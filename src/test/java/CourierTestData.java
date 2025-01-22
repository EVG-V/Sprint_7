public class CourierTestData {

    public static Courier bodyPost() {
        return new Courier("Sokol", "qwerty", "Sam");
    }

    public static Courier notFullBodyPost() {
        return new Courier("Sokol", "", "Sam");
    }

    public static Courier notCompleteBodyPost() {
        return new Courier("Sokol", null, "Sam");
    }

    public static Courier bodyPostWithExistingLogin() {
        return new Courier("Sokol", "12345", "Sam");
    }

    public static Courier bodyPostWithIncorrectData() {
        return new Courier("%!0-={}[", "%!0-={}[", "Sam");
    }

    public static Courier bodyPostWithNonExistentData() {
        return new Courier("Login", "password", "Sam");
    }
}
