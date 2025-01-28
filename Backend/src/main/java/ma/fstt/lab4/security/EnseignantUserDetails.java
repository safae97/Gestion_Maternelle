//
//package ma.fstt.lab4.security;
//
//import ma.fstt.lab4.entities.Enseignant;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//
//public class EnseignantUserDetails implements UserDetails {
//
//    private Enseignant enseignant;
//
//    public EnseignantUserDetails(Enseignant enseignant) {
//        this.enseignant = enseignant;
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        // You can assign roles here if needed (currently no roles defined)
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return enseignant.getPassword();
//    }
//
//    @Override
//    public String getUsername() {
//        return enseignant.getUsername();
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//}
//
