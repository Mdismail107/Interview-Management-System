🎯 Interview Management System (IMS)
A full-stack web application that automates the end-to-end interview process — from job posting to offer/reject decision — built with Java Spring Boot, React.js, and MySQL.

Eliminates manual Excel tracking, prevents double bookings, and streamlines communication between HR, Interview Panels, and Candidates.


🚀 Live Demo

Coming soon / Add your deployment link here


📸 Screenshots

Add screenshots of your HR Dashboard, Candidate Portal, and Panel Availability Calendar here


✨ Features
👔 HR

Create and manage job openings
View and shortlist candidate applications
Schedule interviews by selecting panel availability slots
Send offer/rejection letters with automated email notifications

🧑‍💼 Interview Panel

Set availability slots via a calendar UI
View assigned interviews
Submit structured feedback with ratings (1–5) and outcome

👨‍💻 Candidate

Browse and apply to open jobs
Track application status in real time
View and respond to offer letters

⚙️ System

JWT-based authentication with role-based access control (HR / Panel / Candidate)
Optimistic locking on panel slots to prevent double booking
Automated email notifications for scheduling, cancellations, offers, and rejections
Paginated and filterable list endpoints throughout


🛠️ Tech Stack
LayerTechnologyBackendJava 17, Spring Boot 3.xFrontendReact.js 18, Material UI, AxiosDatabaseMySQL 8.xSecuritySpring Security + JWT (JJWT 0.12.3)ORMSpring Data JPA / HibernateEmailSpring Mail (Gmail SMTP)Build ToolMavenAPI TestingPostmanVersion ControlGit / GitHub

🗂️ Project Structure
src/main/java/com/ims/
├── controller/        # REST API endpoints
├── service/           # Business logic & transactions
├── repository/        # JPA interfaces (DB access)
├── entity/            # JPA-mapped table classes
├── dto/               # Request/Response objects
├── security/          # JWT filter, SecurityConfig
├── exception/         # Global exception handler
├── config/            # Mail, CORS configuration
└── util/              # JWT util, Email builder

🗃️ Database Schema
Key entities and relationships:
Users ──< Applications >── Jobs
  │                          
  ├── PanelAvailability (with @Version for optimistic locking)
  │          │
  └── Interviews ──< Feedback
           │
        Offers ──> Candidates
Application Status Flow:
APPLIED → SHORTLISTED → INTERVIEW_SCHEDULED → SELECTED / REJECTED

⚡ Getting Started
Prerequisites

Java 17+
MySQL 8.x
Node.js 18+
Maven

Backend Setup
bash# 1. Clone the repository
git clone https://github.com/Mdismail107/interview-management-system.git
cd interview-management-system/backend

# 2. Create MySQL database
mysql -u root -p
CREATE DATABASE ims_db;

# 3. Configure application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/ims_db
spring.datasource.username=root
spring.datasource.password=yourpassword
jwt.secret=your_256_bit_secret_key
spring.mail.username=your@gmail.com
spring.mail.password=your_app_password

# 4. Run the backend
mvn spring-boot:run
Backend runs at: http://localhost:8080
Frontend Setup
bashcd ../frontend
npm install
npm start
Frontend runs at: http://localhost:3000

📡 API Endpoints
MethodEndpointAccessDescriptionPOST/auth/registerPublicRegister userPOST/auth/loginPublicLogin, returns JWTGET/jobsHR, CandidateList open jobsPOST/jobsHRCreate jobPOST/applications/applyCandidateApply to a jobPUT/applications/{id}/shortlistHRShortlist candidatePOST/panel/availabilityPanelAdd availability slotPOST/interviews/scheduleHRSchedule interviewPOST/feedbackPanelSubmit feedbackPOST/offers/sendHRSend offer to candidatePUT/offers/{id}/respondCandidateAccept or reject offer
Full API reference available in the Postman Collection (add link).

🔐 Security

All passwords are BCrypt hashed before storage
JWT token required in Authorization: Bearer <token> header for all protected routes
Role-based access enforced at the API level (not just UI)
Optimistic locking (@Version) on panel_availability table prevents concurrent double booking


🔔 Email Notifications
Automated emails are sent at these trigger points:
EventRecipientInterview ScheduledCandidateInterview CancelledCandidate + PanelOffer SentCandidateOffer Accepted/RejectedHR

🧪 Testing
To run a full integration test cycle:

Register HR, Panel, and Candidate users
Login as each role and capture their JWT tokens
Create a job (HR) → Apply (Candidate) → Shortlist (HR)
Add availability (Panel) → Schedule interview (HR)
Submit feedback (Panel) → Send offer (HR) → Accept offer (Candidate)
Test double-booking: fire two concurrent schedule requests to the same slot — only one should succeed


📋 Development Phases

 Phase 1 — JWT Auth, Entities, DB setup
 Phase 2 — Job, Application, Panel, Interview scheduling
 Phase 3 — Feedback, Offers


🤝 Connect
Mohamed Ismail
📧 md391103@gmail.com
🔗 LinkedIn
💻 GitHub
