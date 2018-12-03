package Model;

/**
 *Set of enums to describe game state.
 *
 *Reflections: If we had more time we would still go with enum to define collections of constants
 *this is due to the fact that we required you a predefined list of values which do not represent 
 *some kind of numeric or textual data,
 *
* 
* @author Group 1
* @since November 22,2018

*/

public enum Status {
	win,loose, error,created,inProgress,start,noMoney,purchased,customMode,turnMode,realtimeMode
}
