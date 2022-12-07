-- 드론 테이블
CREATE TABLE IF NOT EXISTS drone (
    uuid VARCHAR(20) PRIMARY KEY COMMENT '드론 고유아이디',
    model_name VARCHAR(30) NOT NULL COMMENT '드론 모델명',
    battery DECIMAL(3,0) DEFAULT 100 COMMENT '배터리',
    loc VARCHAR(50) COMMENT '현재 위치',
    latitude VARCHAR(30) COMMENT '현재 위도',
    longitude VARCHAR(30) COMMENT '현재 경도',
    is_message BOOLEAN COMMENT '드론 통신상태 여부',
    is_use BOOLEAN COMMENT '드론 사용 여부',
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '등록날짜'
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 드론 운행 
CREATE TABLE IF NOT EXISTS drone_driving (
    driving_no BIGINT(20) AUTO_INCREMENT PRIMARY KEY COMMENT '운행 번호',
    uuid VARCHAR(20) COMMENT '드론 고유아이디',
    start_at DATETIME COMMENT '출발 시간',
    end_at DATETIME COMMENT '도착 시간',
    driving_distance DECIMAL(4,1) COMMENT '운행 거리(KM)',
    FOREIGN KEY (uuid) REFERENCES drone (uuid)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


-- 드론 운행 상세이력
CREATE TABLE IF NOT EXISTS drone_driving_history (
    history_no BIGINT(20) AUTO_INCREMENT PRIMARY KEY COMMENT '운행 상세이력 번호',
    driving_no BIGINT(20) COMMENT '운행 번호',
    latitude VARCHAR(30) COMMENT '현재 위도',
    longitude VARCHAR(30) COMMENT '현재 경도',
    create_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '운행 날짜',
    FOREIGN KEY (driving_no) REFERENCES drone_driving (driving_no)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;