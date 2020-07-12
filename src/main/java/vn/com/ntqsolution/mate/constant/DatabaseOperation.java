package vn.com.ntqsolution.mate.constant;

public class DatabaseOperation {

  public static final String ID = "_id";

  public static final String PUSH = "$push";
  public static final String PULL = "$pull";
  public static final String SET = "$set";
  public static final String UNSET = "$unset";
  public static final String NOT_EQUALS = "$ne";
  public static final String LESS_THAN = "$lt";
  public static final String GREATER_THAN = "$gt";
  public static final String INCREASE = "$inc";
  public static final String OR = "$or";
  public static final String IN = "$in";
  public static final String NOT_IN = "$nin";
  public static final String EXISTS = "$exists";
  public static final String AND = "$and";
  public static final String ELEMENT_MATCH = "$elemMatch";
  public static final String GREATER_THAN_OR_EQUAL = "$gte";
  public static final String LESS_THAN_OR_EQUAL = "$lte";
  public static final String ADD_TO_SET = "$addToSet";
  public static final String GROUP = "$group";
  public static final String MATCH = "$match";
  public static final String MAX = "$max";

  public static final int ASCENDING_ORDER = 1;
  public static final int DESCENDING_ORDER = -1;
}
