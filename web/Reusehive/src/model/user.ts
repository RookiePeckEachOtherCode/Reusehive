class User {
  id: String;
  name: String;
  gender: String;
  grade: String;
  academy: String;
  phone_number: String;
  social_info: String;
  avatar_img: String;
  back_img: String;

  constructor(
    id?: String,
    name?: String,
    gender?: String,
    grade?: String,
    academy?: String,
    phone_number?: String,
    social_info?: String,
    avatar_img?: String,
    back_img?: String
  ) {
    this.id = id || "";
    this.name = name || "";
    this.gender = gender || "";
    this.grade = grade || "";
    this.academy = academy || "";
    this.phone_number = phone_number || "";
    this.social_info = social_info || "";
    this.avatar_img = avatar_img || "";
    this.back_img = back_img || "";
  }
}
export default User;
