**Model**
- Result was presented as a class containing the value type int in order to preserve the invariant - the initial value 0.
- Result is inextricably linked to the team. To avoid confusion in the naming of variables in the match class (e.g. home team - home result) they have been included in one class.
- Date and duration are inseparably linked as a entity entity. They contain validations that are dependent on each other.
- Match includes all of the above.

**Simplifications**
- Live matches collection, contains an unwritten invariant that all elements in it have a null end date.
- Summarizing all matches does not take comparator.
- Update method does not verify whether the match is still ongoing while the result is being updated.
- Validations are in setters and constructors.
- The sorting checker is based on the list comparison properties, but it is not transparent.
