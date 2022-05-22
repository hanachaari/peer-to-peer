package peer_to_peer.model;



import java.util.ArrayList;
import peer_to_peer.dao.AvailabilityDao;
import peer_to_peer.dao.StudentDao;



public class Meeting {
private String day;
private float from,to;
private boolean valid = false;
static StudentDao tool = new StudentDao();
private AvailabilityDao tool1 = new AvailabilityDao();




////////////////////////////////////// Getters&Setters ////////////////////////////////////////

public String getDay() {
return day;
}
public void setDay(String day) {
this.day = day;
}
public float getFrom() {
return from;
}
public void setFrom(float from) {
this.from = from;
}
public float getTo() {
return to;
}
public void setTo(float to) {
this.to = to;
}
public boolean isValid() {
return valid;
}
public void setValid(boolean valid) {
this.valid = valid;
}

///////////////////////////////////////////////////////////////// sort from max to min ///////////////////
public ArrayList<Student> sortMaxMin(ArrayList<Student>students, String courseName)
{
int i,j;
Student c = new Student();
for(i=0;i<students.size()-1;i++)
for(j=i+1;j<students.size();j++)
if ( students.get(i).getCourseGrade().get(courseName) < students.get(j).getCourseGrade().get(courseName) ){
c = students.get(i);
students.set(i, students.get(j));
students.set(j, c);
}
return students;
}

///
public ArrayList<Student> sortMinMax(ArrayList<Student>students, String courseName)
{
Student c = new Student();
for (int i = 0; i < students.size()-1; i++)
for (int j = 0; j < students.size()-i-1; j++)
if (students.get(i).getCourseGrade().get(courseName) > students.get(j).getCourseGrade().get(courseName))
{
c = students.get(j);
students.set(j, students.get(j));
students.set(j+1, c);
}
return students;
}
///////////////////////////////////////////////////////////////// sort from min to max ///////////////////
/*public ArrayList sortMinMax(ArrayList<Student>students, String courseName)
{
int i,j;
Student c = new Student();
for(i=0;i<students.size()-1;i++)
for(j=i+1;j<students.size();j++)
if ( students.get(i).getCourseGrade().get(courseName) > students.get(j).getCourseGrade().get(courseName) ){
c = students.get(i);
students.set(i, students.get(j));
students.set(j, c);
}
return students;
}*/
////////////////////////////////////////////////////////////// sortGoodStudents //////////////////////////////////////////////////////

public ArrayList<Student> sortGoodStudents(String course,Level level)
{
ArrayList<Student> students=(ArrayList<Student>)tool.getAll();

ArrayList<Student> goodStudents = new ArrayList<Student>();
for (int i =0; i < students.size(); i++)
{
if ((students.get(i).getLevel().equals(level)== true)&&(students.get(i).getCourseGrade().get(course)>75))
{
goodStudents.add(students.get(i));

}

}
goodStudents = sortMaxMin(goodStudents,course);
return goodStudents;
}

//////////////////////////////////////////////////////////////sortBadStudents //////////////////////////////////////////////////////

public ArrayList<Student> sortBadStudents(String course,Level level)
{
ArrayList<Student> students=(ArrayList<Student>)tool.getAll();
ArrayList<Student> BadStudents = new ArrayList<Student>();
for (int i =0; i < students.size(); i++)
{

if ((students.get(i).getLevel() == level)&&(students.get(i).getCourseGrade().get(course)<50))
{

BadStudents.add(students.get(i));


}

}
BadStudents = sortMinMax(BadStudents,course);
return BadStudents;
}

///////////////////////////////////////////////////////// match students //////////////////////////////////////////
/*public void matchingAvailability (ArrayList<Student>goodStudents,ArrayList<Student>BadStudents)
{
ArrayList<Availability>availablities= (ArrayList<Availability>)tool1.getAll();
ArrayList<String> nbStudentsForTutor = new ArrayList<String>();
String tutored ="";
int s =0;
for(int i = 0; i<goodStudents.size(); i++ )
{
for(int j = 0; j<BadStudents.size(); j++ )
{
int goodStudentAvailabilities = goodStudents.get(i).getAvailablitiesStudent().getTotalAvailabilities();
int BadStudentAvailabilities = BadStudents.get(j).getAvailablitiesStudent().getTotalAvailabilities();
for(int k= 0; k<goodStudentAvailabilities;k++)
{
String goodStudentAvailability = goodStudents.get(i).getAvailablities().get(k).getDay() + goodStudents.get(i).getAvailablities().get(k).getTo() +
goodStudents.get(i).getAvailablities().get(k).getFrom();
for(int z= 0; z<BadStudentAvailabilities;z++)
{
String BadstudentAvailability = BadStudents.get(j).getAvailablities().get(z).getDay() + BadStudents.get(j).getAvailablities().get(z).getTo() +
BadStudents.get(j).getAvailablities().get(z).getFrom();
if( goodStudentAvailability.equals(BadstudentAvailability)&&(s<5))
{
s++;
tutored = tutored + BadStudents.get(j).getFirstName() +" time: "+ BadstudentAvailability;
nbStudentsForTutor.add(tutored);
}

}
}
}
System.out.println(goodStudents.get(i).getFirstName()+goodStudents.get(i).getLastName()+":");
System.out.println(nbStudentsForTutor);
}

}*/

///////////////////////////////////////////////////////// match students //////////////////////////////////////////
public void matchingAvailability(ArrayList<Student>goodStudents,ArrayList<Student>badStudents)
{
ArrayList<Availability>availablities= (ArrayList<Availability>)tool1.getAll();
ArrayList<Student> students=(ArrayList<Student>)tool.getAll();
ArrayList<Availability>availablitiesGoodStudent = new ArrayList<Availability>();
ArrayList<Availability>availablitiesBaddStudent = new ArrayList<Availability>();
ArrayList<String> nbStudentsForTutor = new ArrayList<String>();




int s =0;
String tutored ="";
for(int i =0; i< goodStudents.size(); i++)
{
Student OneGoodStudent = (Student)goodStudents.get(i);

availablitiesGoodStudent.add(OneGoodStudent.getAvailablitiesStudent());
System.out.println("hola");
OneGoodStudent.getAvailablitiesStudent().displayAllAvailabilities();
System.out.println("hola");
for(int k =0; k< badStudents.size(); k++)
{
Student OneBadStudent = (Student)badStudents.get(k);
availablitiesBaddStudent.add(OneBadStudent.getAvailablitiesStudent());
/*for (int j =0; j< students.size(); j++)
{
if(students.get(j).getCourseGrade().equals(nameGoodStudent))
{
availablitiesGoodStudent.add(OneGoodStudent.getAvailablitiesStudent());
}
if(students.get(j).getAvailablitiesStudent().getStudentName().equals(nameBadStudent))
{
availablitiesBaddStudent.add(OneBadStudent.getAvailablitiesStudent());
}

if(availablities.get(j).getStudentName().equals(nameGoodStudent))
{
availablitiesGoodStudent.add(OneGoodStudent.getAvailablitiesStudent());
}
if(availablities.get(j).getStudentName().equals(nameBadStudent))
{
availablitiesBaddStudent.add(OneBadStudent.getAvailablitiesStudent());
}


}*/

for(int x=0; x<availablitiesGoodStudent.size();x++ )
{
Availability availabilityGood = availablitiesGoodStudent.get(x);
String GoodStudentCompleteAvailability = availabilityGood.getDay()+
availabilityGood.getFrom()+availabilityGood.getTo();
for(int t = 0; t< availablitiesBaddStudent.size();t++)
{
Availability availabilityBad = availablitiesBaddStudent.get(t);
String BadStudentCompleteAvailablity = availabilityBad.getDay()+"From: "+
availabilityBad.getFrom()+" To: "+availabilityBad.getTo();
if( BadStudentCompleteAvailablity.equals(GoodStudentCompleteAvailability)&&(s<5))
{
s++;
tutored = tutored + OneBadStudent.getFirstName() +" time: "+ BadStudentCompleteAvailablity;
System.out.println(tutored);
nbStudentsForTutor.add(tutored);
}
}
}


}

System.out.println("Matching:");
System.out.println(OneGoodStudent.getFirstName()+OneGoodStudent.getLastName()+":");
System.out.println(nbStudentsForTutor);


}




}



}