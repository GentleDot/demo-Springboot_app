package net.gentledot.repository;

import net.gentledot.domain.Journal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sang on 2017-06-15.
 */
public interface JournalRepository extends JpaRepository<Journal, Long> {
}
