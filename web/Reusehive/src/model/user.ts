class User {
  id: number;
  name: string;
  gender: string;
  grade: string;
  academy: string;
  phone_number: string;
  social_info: string;
  avatar_img: string;
  back_img: string;

  constructor(
    id: number,
    name: string,
    gender: string,
    grade: string,
    academy: string,
    phone_number: string,
    social_info: string,
    avatar_img: string,
    back_img: string
  ) {
    this.id = id;
    this.name = name;
    this.gender = gender;
    this.grade = grade;
    this.academy = academy;
    this.phone_number = phone_number;
    this.social_info = social_info;
    this.avatar_img = avatar_img;
    this.back_img = back_img;
  }
}
export default User;
