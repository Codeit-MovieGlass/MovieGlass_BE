//package com.movieglass.backend.domain.user.repository;
//
//import com.movieglass.backend.domain.user.entity.User;
//import org.springframework.stereotype.Repository;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Optional;
//
//@Repository
//public class UserRepository {
//
//    private final Map<String, User> userStore = new HashMap<>();
//
//    // 유저 저장
//    public void save(User user) {
//        userStore.put(user.getId(), user);
//    }
//
//    // ID로 유저 찾기
//    public Optional<User> findById(String userId) {
//        return Optional.ofNullable(userStore.get(userId));
//    }
//
//    // 로그인 ID로 유저 찾기
//    public Optional<User> findByLoginId(String loginId) {
//        return userStore.values().stream()
//                .filter(user -> user.getLoginId().equals(loginId))
//                .findFirst();
//    }
//
////    // 테스트 데이터를 초기화
////    public void initializeTestData() {
////        User user1 = new User(
////                "1", "Test User 1", "url1", "test_login_1", "password1", null, null, null
////        );
////        User user2 = new User(
////                "2", "Test User 2", "url2", "test_login_2", "password2", null, null, null
////        );
////        save(user1);
////        save(user2);
////    }
//}
package com.movieglass.backend.domain.user.repository;

import com.movieglass.backend.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginId(String loginId);
}
