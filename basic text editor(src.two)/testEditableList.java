public class testEditableList
{
  public static void main(String[] args)
  {
    EditableList strings = new EditableList();
    strings.append("1");
    strings.append("2");
    strings.append("3");
    strings.insert(1,"0");
    strings.insert(1,"-1");
    strings.insert(1,"-2");
    strings.insert(1, "insert");
    strings.replace(0, "repalcement");
    System.out.println(strings.toString()); // strings with weird comma action
    
  } 
}
