-- Runs automatically the first time the MySQL container initialises
-- (mounted into /docker-entrypoint-initdb.d/). Creates the single required
-- table and seeds it with 8 records (within the 5-10 range).

CREATE TABLE IF NOT EXISTS employees (
    id          BIGINT PRIMARY KEY,
    name        VARCHAR(100) NOT NULL,
    department  VARCHAR(100) NOT NULL,
    role        VARCHAR(100) NOT NULL
);

INSERT INTO employees (id, name, department, role) VALUES
    (1, 'Aarav Sharma',    'Engineering', 'Backend Developer'),
    (2, 'Priya Nair',      'Engineering', 'DevOps Engineer'),
    (3, 'Rohan Mehta',     'Platform',    'SRE'),
    (4, 'Isha Verma',      'Product',     'Product Manager'),
    (5, 'Karan Singh',     'Cloud',       'FinOps Analyst'),
    (6, 'Neha Kapoor',     'Engineering', 'Frontend Developer'),
    (7, 'Vikram Iyer',     'Platform',    'Kubernetes Admin'),
    (8, 'Ananya Reddy',    'QA',          'Automation Engineer');
