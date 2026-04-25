# Manuel Test Senaryoları — automationexercise.com

## Test Ortamı

| Alan | Bilgi |
|------|-------|
| Site | https://www.automationexercise.com |
| Tarayıcı | Chrome (son versiyon) |
| Test Tarihi | |
| Test Eden | |

---

## UI Test Senaryoları

---

### TC-UI-001: Başarılı Kullanıcı Girişi

| Alan | Bilgi |
|------|-------|
| Öncelik | Yüksek |
| Tür | Pozitif |

**Ön Koşul:** Kayıtlı kullanıcı hesabı mevcut

| # | Adım | Test Verisi | Beklenen Sonuç | Gerçekleşen | Durum |
|---|------|-------------|----------------|-------------|-------|
| 1 | Ana sayfaya git | https://www.automationexercise.com | Ana sayfa yüklendi | | |
| 2 | "Signup / Login" linkine tıkla | — | Login sayfası açıldı | | |
| 3 | E-posta gir | ahmetturan1687@gmail.com | E-posta girildi | | |
| 4 | Şifre gir | Test1234! | Şifre girildi | | |
| 5 | "Login" butonuna tıkla | — | Ana sayfaya yönlendirildi | | |
| 6 | Üst menüde kullanıcı adını kontrol et | — | "Logged in as [isim]" görünüyor | | |

---

### TC-UI-002: Hatalı Şifre ile Giriş

| Alan | Bilgi |
|------|-------|
| Öncelik | Yüksek |
| Tür | Negatif |

| # | Adım | Test Verisi | Beklenen Sonuç | Gerçekleşen | Durum |
|---|------|-------------|----------------|-------------|-------|
| 1 | Login sayfasına git | — | Login sayfası açıldı | | |
| 2 | E-posta gir | ahmetturan1687@gmail.com | E-posta girildi | | |
| 3 | Yanlış şifre gir | YanlisŞifre123 | Şifre girildi | | |
| 4 | "Login" butonuna tıkla | — | Hata mesajı görüntülendi | | |
| 5 | Hata mesajını kontrol et | — | "Your email or password is not correct!" | | |

---

### TC-UI-003: Başarılı Çıkış

| Alan | Bilgi |
|------|-------|
| Öncelik | Yüksek |
| Tür | Pozitif |

**Ön Koşul:** Kullanıcı giriş yapmış

| # | Adım | Test Verisi | Beklenen Sonuç | Gerçekleşen | Durum |
|---|------|-------------|----------------|-------------|-------|
| 1 | Giriş yapılmış durumda ana sayfada ol | — | "Logged in as [isim]" görünüyor | | |
| 2 | "Logout" linkine tıkla | — | Login sayfasına yönlendirildi | | |
| 3 | URL'yi kontrol et | — | URL /login içeriyor | | |
| 4 | Kullanıcı adının kaybolduğunu doğrula | — | "Logged in as" yazısı yok | | |

---

### TC-UI-004: Ürünler Sayfasına Gitme

| Alan | Bilgi |
|------|-------|
| Öncelik | Orta |
| Tür | Pozitif |

| # | Adım | Test Verisi | Beklenen Sonuç | Gerçekleşen | Durum |
|---|------|-------------|----------------|-------------|-------|
| 1 | Ana sayfaya git | — | Ana sayfa yüklendi | | |
| 2 | Üst menüden "Products" linkine tıkla | — | Ürünler sayfası açıldı | | |
| 3 | Ürün listesini kontrol et | — | En az 1 ürün görünüyor | | |
| 4 | Sayfa başlığını kontrol et | — | "All Products" başlığı var | | |

---

### TC-UI-005: Ürün Arama — Geçerli Kelime

| Alan | Bilgi |
|------|-------|
| Öncelik | Orta |
| Tür | Pozitif |

| # | Adım | Test Verisi | Beklenen Sonuç | Gerçekleşen | Durum |
|---|------|-------------|----------------|-------------|-------|
| 1 | Ürünler sayfasına git | — | Ürünler sayfası açıldı | | |
| 2 | Arama kutusuna yaz | dress | Kelime girildi | | |
| 3 | Arama butonuna tıkla | — | Arama gerçekleşti | | |
| 4 | Sonuçları kontrol et | — | "Searched Products" başlığı + ürün listesi görünüyor | | |
| 5 | Ürün adlarını kontrol et | — | Sonuçlarda "dress" ile ilgili ürünler var | | |

---

### TC-UI-006: Sepete Ürün Ekleme

| Alan | Bilgi |
|------|-------|
| Öncelik | Yüksek |
| Tür | Pozitif |

| # | Adım | Test Verisi | Beklenen Sonuç | Gerçekleşen | Durum |
|---|------|-------------|----------------|-------------|-------|
| 1 | Ürünler sayfasına git | — | Ürünler listelendi | | |
| 2 | İlk ürünün üzerine hover yap | — | "Add to cart" butonu görünür | | |
| 3 | "Add to cart" butonuna tıkla | — | Modal pencere açıldı | | |
| 4 | "Continue Shopping" seç | — | Modal kapandı | | |
| 5 | Üst menüden "Cart" ikonuna tıkla | — | Sepet sayfası açıldı | | |
| 6 | Sepet içeriğini kontrol et | — | Eklenen ürün sepette görünüyor | | |

---

## API Test Senaryoları

---

### TC-API-001: Tüm Ürün Listesini Al

| Alan | Bilgi |
|------|-------|
| Endpoint | GET /api/productsList |
| Öncelik | Yüksek |

| # | Kontrol | Beklenen | Gerçekleşen | Durum |
|---|---------|----------|-------------|-------|
| 1 | HTTP Status Code | 200 | | |
| 2 | responseCode | 200 | | |
| 3 | products alanı | Boş olmayan liste | | |
| 4 | products[0].id | Sayısal değer | | |
| 5 | products[0].name | String değer | | |
| 6 | Yanıt süresi | < 3 saniye | | |

**Test Komutu (Postman/curl):**
```
GET https://automationexercise.com/api/productsList
```

---

### TC-API-002: Ürün Arama

| Alan | Bilgi |
|------|-------|
| Endpoint | POST /api/searchProduct |
| Öncelik | Orta |

| # | Kontrol | Beklenen | Gerçekleşen | Durum |
|---|---------|----------|-------------|-------|
| 1 | HTTP Status Code | 200 | | |
| 2 | responseCode | 200 | | |
| 3 | products alanı | Boş olmayan liste | | |

**Test Komutu:**
```
POST https://automationexercise.com/api/searchProduct
Body (form-data): search_product=dress
```

---

### TC-API-003: Geçerli Kullanıcı Girişini Doğrula

| Alan | Bilgi |
|------|-------|
| Endpoint | POST /api/verifyLogin |
| Öncelik | Yüksek |

| # | Kontrol | Beklenen | Gerçekleşen | Durum |
|---|---------|----------|-------------|-------|
| 1 | HTTP Status Code | 200 | | |
| 2 | responseCode | 200 | | |
| 3 | message | "User exists!" | | |

**Test Komutu:**
```
POST https://automationexercise.com/api/verifyLogin
Body (form-data): email=ahmetturan1687@gmail.com&password=Test1234!
```

---

### TC-API-004: Kullanıcı Hesabı Oluşturma

| Alan | Bilgi |
|------|-------|
| Endpoint | POST /api/createAccount |
| Öncelik | Yüksek |

| # | Kontrol | Beklenen | Gerçekleşen | Durum |
|---|---------|----------|-------------|-------|
| 1 | HTTP Status Code | 200 | | |
| 2 | responseCode | 201 | | |
| 3 | message | "User created!" | | |

---

### TC-API-005: Kullanıcı Hesabını Silme

| Alan | Bilgi |
|------|-------|
| Endpoint | DELETE /api/deleteAccount |
| Öncelik | Orta |

| # | Kontrol | Beklenen | Gerçekleşen | Durum |
|---|---------|----------|-------------|-------|
| 1 | HTTP Status Code | 200 | | |
| 2 | responseCode | 200 | | |
| 3 | message | "Account deleted!" | | |

---

## Test Execution Özeti

| Kategori | Toplam | Geçti | Başarısız | Atlandı |
|----------|--------|-------|-----------|---------|
| UI Tests | 6 | | | |
| API Tests | 5 | | | |
| **Toplam** | **11** | | | |

**Test Tarihi:**
**Test Eden:**
**Genel Sonuç:** Geçti / Başarısız
