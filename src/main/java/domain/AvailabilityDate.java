package domain;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "availability_dates")
public class AvailabilityDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hut_id", nullable = false)
    private Hut hut;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "scan_timestamp", nullable = false)
    private LocalDate scanTimestamp;

    // Constructors, getters, and setters
    public AvailabilityDate() {
    }

    public AvailabilityDate(Hut hut, LocalDate date) {
        this.hut = hut;
        this.date = date;
        this.scanTimestamp = LocalDate.now(); // Default to current date
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hut getHut() {
        return hut;
    }

    public void setHut(Hut hut) {
        this.hut = hut;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getScanTimestamp() {
        return scanTimestamp;
    }

    public void setScanTimestamp(LocalDate scanTimestamp) {
        this.scanTimestamp = scanTimestamp;
    }
}
