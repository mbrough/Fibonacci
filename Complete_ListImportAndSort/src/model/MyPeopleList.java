/*
 * Molly Brougham
 * Project 1
 * TCSS 305 S'15
 */

package model;

/**
 * Represents a list of people with the ability to sort 
 * by name, phone number, or email address.
 * @author Molly Brougham
 * @version 1.0
 */
public class MyPeopleList extends MyList {

    /** creates an empty list of elements with a default size of 10. */
    public MyPeopleList() {
        this(DEFAULT_SIZE);
    }
    
    /**
     * creates an empty list of people with a given size.
     * @param theSize the size of the list to be created,
     */
    public MyPeopleList(final int theSize) {
        super(theSize);
    }
    
    /** Sorts the list by last name, first name. */
    public void sortByName() {
        boolean sortAgain = false;
        for (int i = 0; i < myLength; i++) {
            if (myElements[i + 1] != null && myElements[i] instanceof Person
                && myElements[i + 1] instanceof Person) {
                final Person person1 = (Person) myElements[i];
                final Person person2 = (Person) myElements[i + 1];
                if (person1.compareTo(person2) > 0) {
                    myElements[i] = person2;
                    myElements[i + 1] = person1;
                    sortAgain = true;
                }
            }
        }
        if (sortAgain) {
            sortByName();
        }
    }
    
    /** 
     * Sorts the list by phone number. 
     */
    public void sortByPhone() {
        boolean sortAgain = false;
        for (int i = 0; i < myLength; i++) {
            if (myElements[i + 1] != null && myElements[i] instanceof Person
                && myElements[i + 1] instanceof Person) {
                final Person person1 = (Person) myElements[i];
                final Person person2 = (Person) myElements[i + 1];
                if (person1.comparePhone(person2) > 0) {
                    myElements[i] = person2;
                    myElements[i + 1] = person1;
                    sortAgain = true;
                }
            }
            
            if (sortAgain) {
                sortByPhone();
            }
        }
    }
    
    /** Sorts the list by email address. */
    public void sortByEmail() {
        boolean sortAgain = false;
        for (int i = 0; i < myLength; i++) {
            if (myElements[i + 1] != null && myElements[i] instanceof Person
                && myElements[i + 1] instanceof Person) {
                final Person person1 = (Person) myElements[i];
                final Person person2 = (Person) myElements[i + 1];
                if (person1.compareEmail(person2) > 0) {
                    myElements[i] = person2;
                    myElements[i + 1] = person1;
                    sortAgain = true;
                }
            }
        }
        if (sortAgain) {
            sortByEmail();
        }
    }

    /**
     * Determines whether there is a person in the list with a given name.
     * @param theName The name.
     * @return whether or not the list contains a person with the name.
     */
    public boolean containsPersonWithName(final String theName) {
        boolean toReturn = false;
        for (int i = 0; i < myLength; i++) {
            if (myElements[i] instanceof Person) {
                final Person person = (Person) myElements[i];

                final String currentName = person.getFullName();
                if (theName.equals(currentName)) {
                    toReturn = true;
                }
                    
            }
        }
        return toReturn;
    } 
    
    /**
     * Returns a person with a given name.
     * @param theName the name of the person to return
     * @return the person with the given name
     */
    public Person getPersonWithName(final String theName) {
        int index = 0;
        for (int i = 0; i < myLength; i++) {
            if (myElements[i] instanceof Person) {
                final Person person = (Person) myElements[i];
                final String currentName = person.getFullName();
                if (theName.equals(currentName)) {
                    index = i;
                }  
            }
        }
        return (Person) myElements[index];
    }

    /**
     * returns the index of the person with a given first and last name.
     * @param theFirstName the first name of the person
     * @param theLastName the last name of the person
     * @return -1 if the person is not in the list, 
     * or the location of the person with that name.
     */
    public int getIndexOf(final String theFirstName, final String theLastName) {
        int toReturn = -1;
        for (int i = 0; i < myLength; i++) {
            final Person currentPerson = (Person) myElements[i];
            if (currentPerson.getFirstName().equals(theFirstName) 
                            && currentPerson.getLastName().equals(theLastName)) {
                toReturn = i;
            }
        }
        return toReturn;
    }
}
