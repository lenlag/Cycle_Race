# Cycle_Race
Cycle_Race

In this project My SQL database is created using JPA annotations.

All the repositories extend CrudRepository.

In Application.java I use @Transactional  public void run()... to create a temporary Session to deal with "LAZY" Entities.

All the repositories are tested via JUnit (using h2 test in-memory database).
