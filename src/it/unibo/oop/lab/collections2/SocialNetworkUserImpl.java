package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */
	private final Map<String, List<U>> followed;

    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */
	
	public SocialNetworkUserImpl(String firstName, String lastName, String username) {
		this(firstName, lastName, username, -1);
	}

    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.followed = new HashMap<>();
    }

    /*
     * [METHODS]
     * 
     * Implements the methods below
     */
    
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
    	/* check if @user is already followed */
    	for(List<U> groupList : this.followed.values()) {
    		if(groupList.contains(user)) {
    			return false;
    		}
    	}
    	/* finds if the group exists, and then adds the user to the group's list */
    	if(this.followed.containsKey(circle)) {
    		if(!this.followed.get(circle).contains(user)) {
    			this.followed.get(circle).add(user);
    			return true;
    		}
    	}
    	/* otherwise a new key is created with, as its value, a new list composed of the new followed user */
    	this.followed.put(circle, new ArrayList<>(List.of(user)));
    	return true;
    }

    public Collection<U> getFollowedUsersInGroup(final String groupName) {
    	if(this.followed.containsKey(groupName)) {
    		return new ArrayList<U>(List.copyOf(this.followed.get(groupName)));
    	}
    	return new ArrayList<U>();
    }

    public List<U> getFollowedUsers() {
        List<U> followedUsers = new ArrayList<>();
        for(List<U> groupList : this.followed.values()) {
        	followedUsers.addAll(groupList);
        }
    	return new ArrayList<U>(List.copyOf(followedUsers));
    }

}
