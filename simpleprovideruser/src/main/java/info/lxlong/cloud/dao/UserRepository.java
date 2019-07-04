package info.lxlong.cloud.dao;

import info.lxlong.cloud.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created with IDEA
 * Date:2018/11/30
 * Time:15:17
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
