package io.nenodias.evento.repository;

import io.nenodias.evento.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
