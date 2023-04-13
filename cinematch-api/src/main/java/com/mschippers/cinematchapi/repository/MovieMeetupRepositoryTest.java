// package com.mschippers.cinematchapi.repository;

// import static org.assertj.core.api.Assertions.assertThat;

// import java.time.LocalDateTime;
// import java.util.List;

// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

// import com.mschippers.cinematchapi.model.MovieMeetup;

// @DataJpaTest
// public class MovieMeetupRepositoryTest {

//     @Autowired
//     private MovieMeetupRepository repository;

//     @Test
//     public void testFindByLocation() {
//         MovieMeetup meetup1 = new MovieMeetup("Inception", LocalDateTime.of(2022, 3, 30, 14, 30), "Amsterdam");
//         MovieMeetup meetup2 = new MovieMeetup("The Matrix", LocalDateTime.of(2022, 4, 1, 19, 0), "Rotterdam");
//         repository.save(meetup1);
//         repository.save(meetup2);
        
//         List<MovieMeetup> meetups = repository.findByLocation("Amsterdam");
//         assertThat(meetups).containsExactly(meetup1);
//     }
// }

